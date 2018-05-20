(ns clojure-for-brave-and-true.chapter1.exercise4)

(defn mapset
  "Maps specified collection and returns set of the result"
  [f coll]
  (set (map f coll)))

(println (mapset #(* % 2) '(1 2 3 1 2 4 5)))


