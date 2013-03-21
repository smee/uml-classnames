(ns uml-classnames.core
  (:require [org.clojars.smee.file :refer [find-files]]
            [clojure walk
             [string :refer [join]]
             [xml :as xml]
             [zip :as zip]]
            [clojure.java.io :as io]
            [clojure.data.zip.xml :refer (xml-> attr=)]
            [clojure.data.zip :as zf])
  (:gen-class))


(defn -main [& args]
  (doseq [file (find-files (first args) #".*.uml")
          :let [x (zip/xml-zip (xml/parse (io/input-stream file)))
                classes (xml-> x zf/descendants :packagedElement [(attr= :xmi:type "uml:Class")])]] 
    (doseq [class classes]
      (println (join "." (concat (->> class zip/path (keep #(when (= "uml:Package" (-> % :attrs :xmi:type)) (-> % :attrs :name))))
                                 (-> class zip/node :attrs :name vector)))))))
