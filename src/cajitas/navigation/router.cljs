(ns cajitas.navigation.router
  (:require [cajitas.shared.ui :as ui]
            [cajitas.scenes.home :as home]))

(def router (ui/create-router
              (fn []
                  #js {:home home/home-scene})))