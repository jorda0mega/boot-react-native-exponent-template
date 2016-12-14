(ns example.navigation.router
  (:require [example.shared.ui :as ui]
            [example.scenes.home :as home]))

(def router (ui/create-router
              (fn []
                  #js {:home home/home-scene})))