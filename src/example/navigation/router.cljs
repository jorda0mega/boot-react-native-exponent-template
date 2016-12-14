(ns example.navigation.router
  (:require [example.shared.ui :as ui]
            [example.scenes.home :as home]
            [example.scenes.detail :as detail]))

(def router (ui/create-router
              (fn []
                  #js {:home home/home-scene
                       :detail detail/detail-scene})))