(ns example.scenes.home
  (:require [cljs-exponent.reagent :refer [view text]]
            [example.components.clickable-text :refer [clickable-text]]
            [example.utils :as util]))

(defn home-cp
      []
      [view {:style {:flex 1
                     :background-color "white"
                     :justify-content "center"
                     :align-items "center"}}
        [clickable-text "Click me!!"]])

(defn home-scene
      [props]
      (util/wrap-route home-cp {:navigationBar {:title "Home"
                                                :titleStyle {:color "black"}
                                                :backgroundColor "white"}}))