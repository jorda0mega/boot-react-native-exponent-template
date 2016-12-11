(ns cajitas.handlers
  (:require
    [re-frame.core :refer [reg-event-db after]]
    [cajitas.db :refer [app-db]]))

;; -- Handlers --------------------------------------------------------------

(reg-event-db
  :initialize-db
  (fn [_ _]
      app-db))

(reg-event-db
  :set-offerings
  (fn [db [_ value]]
    (assoc db :offerings value)))