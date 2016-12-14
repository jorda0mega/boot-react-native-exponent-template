(ns example.scenes.detail
  (:require [cljs-exponent.reagent :as rn :refer [view text]]
            [example.utils :as util]))

(defn detail-cp
      []
      [rn/view {:style {:flex 1
                     :background-color "white"
                     :justify-content "center"
                     :align-items "center"}}
       [rn/text "You clicked me. Congrats!!"]])

(defn detail-scene
      [props]
      (util/wrap-route detail-cp {:navigationBar {:title "Detail"
                                                :titleStyle {:color "black"}
                                                :backgroundColor "white"}}))