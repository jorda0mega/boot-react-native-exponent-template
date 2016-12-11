(ns cajitas.db
  (:require [clojure.spec :as s]))

;; initial state of app-db
(def app-db {:root-nav nil
             :nav nil
             :offerings [{:key 1 :plate_name "congris" :image "congris.png"}
                         {:key 2 :plate_name "churrasco" :image "churrasco.jpg"}]})
