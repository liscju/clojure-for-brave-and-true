(ns clojure-for-brave-and-true.chapter1.exercise3)

(defn dec-maker
  "Creates decrement function that substracts argument by specified value"
  [substractor]
  #(- % substractor))

(def dec9 (dec-maker 9))

(println (dec9 10))
