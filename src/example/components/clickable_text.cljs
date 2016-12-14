(ns example.components.clickable-text
  (:require [clojure.string :as str]
            [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [cljs-exponent.reagent :refer [text view image touchable-highlight] :as rn]
            [example.scenes.detail :refer [detail-scene]]
            [example.handlers]
            [example.subs]
            [example.shared.ui :as ui]))
(def styles
  (ui/create-stylesheet
    {:image
     {:height 50 :width 50}
     :text
     {:font-weight "100" :width 100 :height 50}
     :column
     {:flex-direction "column"
      :align-items "center"}}))

(def logo (js/require "../../assets/cljs.png"))

(defn clickable-text [inner-text]
      [rn/view {:style {:margin-top 50
                        :margin-left 8
                        :justify-content "center"
                        :align-items "center"}}
       [rn/text {:style {:font-family "Helvetica"
                         :font-size 20
                         :margin-bottom 20}}
        "Welcome to boot-react-native-exponent"]
       [rn/image {:style {:width 350
                          :height 348
                          :margin-bottom 20}
                  :source logo}]
       [rn/touchable-highlight {:style {:padding 20
                                        :background-color "#e0e0e0"}
                                :on-press #(dispatch [:nav/push {:key :detail}])
                                :underlay-color "#f0f0f0"}
        [rn/text {:style {:font-family "Helvetica"
                          :font-size 14}}
         inner-text]]])
