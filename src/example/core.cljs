(ns example.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [example.handlers]
            [example.subs]
            [example.shared.ui :as ui]
            [example.navigation.router :as router]
            [example.components.clickable-text :refer [clickable-text]]
            [cljs-exponent.reagent :refer [text view image touchable-highlight] :as rn]
            [cljs.test :as test]))

(enable-console-print!)

;; we need set! for advanced compilation

(set! js/React (js/require "react-native/Libraries/react-native/react-native.js"))
(defonce react (js/require "react-native/Libraries/react-native/react-native.js"))

;; Assets need to be relative path, starting from the `app/build/node_modules'
;; directory. The packager only finds images located in the `app/' folder
;; (the directory that contains package.json) or below.
;;
;; We use `defonce' to prevent errors on subsequent reloads.

(def styles
  (ui/create-stylesheet
    {:scroll-view
     {:flex-direction "column"
      :align-items "flex-start"
      :margin-top 60}
     :no-results
      {:flex-direction "column"
       :align-items "center"
       :margin-top 60}}))

;(defn root-view []
;      (let [offerings (subscribe [:get-offerings])]
;           (if-not (nil? (:state offerings))
;                   (fn []
;                       [ui/scroll-view {:content-container-style (:scroll-view styles)}
;                        (for [offering @offerings]
;                             [offering-row offering])])
;                   [ui/view {:style (:no-results styles)}
;                    [ui/text {:style {:font-style "italic" :color "#BDBCD9"}}
;                     "No offerings available at this time"]])))

(defonce logo (js/require "../../assets/cljs.png"))

;(defn root-view []
;      (let [offerings (subscribe [:get-offerings])]
;           (fn []
;               [ui/scroll-view {:content-container-style (:scroll-view styles)}
;                (for [offering @offerings]
;                     [offering-row offering])])))


(defn root-view []
      [ui/navigation-provider {:router router/router}
       [ui/stack-navigation {:id "root"
                             :initialRoute "home"}]])

(defn root-container
  "Wraps root-view. This is to make sure live reloading using boot-reload and
  reagent works as expected. Instead of editing root-container, edit root-view"
  []
  [root-view])

(defn ^:export main
  []
  (js/console.log "MAIN")
  (enable-console-print!)
  (dispatch-sync [:initialize-db])
  (.registerComponent rn/app-registry
                      "main"
                      #(r/reactify-component #'root-container)))

(defn on-js-reload
  []
  (println "on-js-reload. state:" (pr-str (subscribe [:get-offerings])))

  ;; Force re-render
  ;;
  ;; In React native, there are no DOM nodes. Instead, mounted
  ;; components are identified by numbers. The first root components
  ;; is assigned the number 1.

  (r/render #'root-container 1))
