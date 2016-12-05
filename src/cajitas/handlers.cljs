(ns cajitas.handlers
  (:require
    [re-frame.core :refer [register-handler after]]
    [cajitas.db :refer [app-db]]))

;; -- Handlers --------------------------------------------------------------

(register-handler
  :initialize-db
  (fn [_ _]
      app-db))

(register-handler
  :set-offerings
  (fn [db [_ value]]
    (assoc db :offerings value)))

;(register-handler
;  :set-greeting
;  validate-schema-mw
;  (fn [db [_ value]]
;    (assoc db :greeting value)))