(ns example.handlers
  (:require
    [re-frame.core :refer [reg-event-db after]]
    [clojure.spec :as s]
    [example.db :as db :refer [app-db]]))

;; -- Middleware
(defn check-and-throw
      "Throw an exception if db doesn't have a valid spec."
      [spec db]
      (when-not (s/valid? spec db)
                (let [explain-data (s/explain-data spec db)]
                     (throw (ex-info (str "Spec check failed: " explain-data) explain-data)))))

(def validate-spec-mw
  (if goog.DEBUG
    (after (partial check-and-throw ::db/app-db))
    []))

;; -- Handlers --------------------------------------------------------------
(reg-event-db
  :initialize-db
  (fn [_ _]
      app-db))

;; -- Navigation ------------------------------------------------------------
(reg-event-db
  :nav/set-nav
  (fn [db [_ value]]
      (merge db value)))

(reg-event-db
  :nav/push
  (fn [db [_ {:keys [key]
              :as route}]]
      (when-let [nav (:nav db)]
                (.push nav
                       (name key)
                       (clj->js (dissoc route :key))))
      db))

(reg-event-db
  :nav/root-push
  (fn [db [_ {:keys [key]
              :as route}]]
      (when-let [root-nav (:root-nav db)]
                (.push root-nav
                       (name key)
                       (clj->js (dissoc route :key))))
      db))

(reg-event-db
  :nav/pop
  (fn [db _]
      (when-let [nav (:nav db)]
                (.pop nav))
      db))

(reg-event-db
  :nav/show-local-alert
  (fn [db [_ text style]]
      (when-let [nav (:nav db)]
                (.showLocalAlert (:navigator nav) text (clj->js style)))
      db))

;; -- Cajitas ------------------------------------------------------------
(reg-event-db
  :set-offerings
  (fn [db [_ value]]
    (assoc db :offerings value)))