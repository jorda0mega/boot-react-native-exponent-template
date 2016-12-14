(ns example.scenes.home
  (:require [cljs-exponent.reagent :refer [view text]]
            [example.utils :as util]))

(defn home-cp
      []
      [view {:style {:flex 1
                     :background-color "white"
                     :justify-content "center"
                     :align-items "center"}}
       [text {:style {:font-size 24
                      :font-weight "bold"
                      :color "black"}}
        "First Scene"]])

(defn home-scene
      [props]
      (util/wrap-route home-cp {:navigationBar {:title "Home"
                                                :titleStyle {:color "black"}
                                                :backgroundColor "white"}}))