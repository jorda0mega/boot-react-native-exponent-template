(ns example.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [reg-sub-raw]]))

(reg-sub-raw
  :get-greeting
  (fn [db _]
    (js/console.info (reaction (get @db :greeting)))
    (reaction
     (get @db :greeting))))