(ns example.db
  (:require [clojure.spec :as s]))

;; initial state of app-db
(def app-db {:root-nav nil
             :nav nil
             :greeting "Hello world!"})
