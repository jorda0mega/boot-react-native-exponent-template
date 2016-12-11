(ns cajitas.scenes.home
  (:require [cljs-exponent.reagent :refer [view text]]
            [cajitas.utils :as util]))

(defn home-cp
      []
      [view {:style {:flex 1
                     :background-color "orange"
                     :justify-content "center"
                     :align-items "center"}}
       [text {:style {:font-size 24
                      :font-weight "bold"
                      :color "white"}}
        "First Scene"]])

(defn home-scene
      [props]
      (util/wrap-route home-cp {:navigationBar {:title "Home"
                                                :titleStyle {:color "white"}
                                                :backgroundColor "orange"}}))