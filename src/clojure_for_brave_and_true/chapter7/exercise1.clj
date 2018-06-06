(ns clojure-for-brave-and-true.chapter7.exercise1)

(def sci-fi-movie-printer
  (read-string "(println \"My favourite sci-fi movie is the Withcer\")"))

(eval sci-fi-movie-printer)