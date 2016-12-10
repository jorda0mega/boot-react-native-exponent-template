(ns cajitas.shared.ui
  (:require [reagent.core :as r]
            [medley.core :as m]
            [cajitas.utils :as u]
            [camel-snake-kebab.core :as cs :include-macros true]))

(def ReactNative (js/require "react-native"))

;react-native
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def EStyleSheet (aget (js/require "react-native-extended-stylesheet") "default"))

;ex-navigation
(def ExNavigation (js/require "@exponent/ex-navigation"))
;(def create-router (aget ExNavigation "createRouter"))
;(def NavigationProvider (aget ExNavigation "NavigationProvider"))
;(def navigation-provider (r/adapt-react-class NavigationProvider))
;(def StackNavigation (aget ExNavigation "StackNavigation"))
;(def stack-navigation (r/adapt-react-class StackNavigation))
;(def TabNavigation (aget ExNavigation "TabNavigation"))
;(def tab-navigation (r/adapt-react-class TabNavigation))
;(def TabNavigationItem (aget ExNavigation "TabNavigationItem"))
;(def tab-navigation-item (r/adapt-react-class TabNavigationItem))

(defn get-window
  ([] (get-window identity))
  ([f]
   (f (u/js->cljk (dim/get "window")))))

(defn build-stylesheet
  ([] (build-stylesheet {}))
  ([vals]
   (.build EStyleSheet (clj->js vals))))

(defn create-stylesheet [styles]
  (-> (m/map-vals #(u/apply-if map? (partial m/map-keys cs/->camelCase) %) styles)
      clj->js
      (->> (.create EStyleSheet))
      u/obj->hash-map))

(defn alert [title]
  (.alert (.-Alert ReactNative) title))

(build-stylesheet)