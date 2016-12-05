(ns cajitas.components.offering-row
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [cajitas.handlers]
            [cajitas.subs]
            [cajitas.shared.ui :as ui]))
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

(defonce congris (js/require "../../assets/congris.png"))

(defmacro static-img [filename]
          `(js/require ~(str "../../assets/" filename)))

(defn offering-row [offering]
      [ui/touchable-highlight {:on-press #(ui/alert (:plate_name offering))}
       [ui/view {:style (:row styles)}
        [ui/image {:source (static-img (:image offering)) :style (:image styles)}]
        [ui/view {:style {:flex-direction "column" :justify-content "center" :padding-left 10}}
         [ui/text {:style (:text styles)} (:plate_name offering)]]]])
