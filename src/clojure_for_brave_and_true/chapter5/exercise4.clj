(ns clojure-for-brave-and-true.chapter5.exercise4)

(update-in {:key1 {:key2 2}} [:key1 :key2] inc)