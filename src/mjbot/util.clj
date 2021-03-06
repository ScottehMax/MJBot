(ns mjbot.util
  (:require [clojure.string :as string]))

(defn string-to-id [poke]
  (string/lower-case (string/replace poke #"[^\p{L}\p{Nd}]+" "")))

(defn get-poke-from-details [data]
  (keyword (string-to-id (get (string/split data #",") 0))))

(defn type-of-hidden-power [hp]
  (keyword (string/capitalize (subs hp 11 (- (count hp) 2)))))

(defn map-to-vec [m]
  (loop [m m
         v []]
    (if (seq m)
      (recur (rest m)
             (conj v (get (first m) 1)))
      v)))

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s)))