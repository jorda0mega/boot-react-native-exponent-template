(ns example.components.clickable-text
  (:require [clojure.string :as str]
            [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [cljs-exponent.reagent :refer [text view image touchable-highlight] :as rn]
            [example.handlers]
            [example.subs]
            [example.shared.ui :as ui]))
(def styles
  (ui/create-stylesheet
    {:image
     {:height 50 :width 50}
     :text
     {:font-weight "100"}
     :row
     {:flex-direction "row"
      :align-items "center"
      :height 50
      :width "100%"}}))

(def logo (js/require "../../assets/cljs.png"))

(defn clickable-text [inner-text]
      [rn/touchable-highlight {:on-press #(ui/alert inner-text)}
       [rn/view {:style (:row styles)}
        [rn/image {:source logo :style (:image styles)}]
        [rn/view {:style {:flex-direction "column" :justify-content "center" :padding-left 10}}
         [rn/text {:style (:text styles)} (:plate_name offering)]]]])
