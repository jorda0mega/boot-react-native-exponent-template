(ns cajitas.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [reg-sub-raw]]))

(reg-sub-raw
  :get-offerings
  (fn [db _]
    (js/console.info (reaction (get @db :offerings)))
    (reaction
     (get @db :offerings))))