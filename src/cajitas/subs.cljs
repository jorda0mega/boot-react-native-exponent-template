(ns cajitas.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
  :get-greeting
  (fn [db _]
    (reaction
      (get @db :greeting))))

(register-sub
  :get-offerings
  (fn [db _]
    (js/console.info (reaction (get @db :offerings)))
    (reaction
     (get @db :offerings))))