(ns cajitas.shared.ui
  (:require [reagent.core :as r]
            [medley.core :as m]
            [cajitas.utils :as u]
            [camel-snake-kebab.core :as cs :include-macros true]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def EStyleSheet (aget (js/require "react-native-extended-stylesheet") "default"))


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