(ns clojure-for-brave-and-true.chapter5.exercise3)

(defn assoc-in
  "Associates value in map with specified value"
  ([m [k & ks] v]
   (if ks
     (assoc m k (assoc-in (get m k {}) ks v))
     (assoc m k v))))