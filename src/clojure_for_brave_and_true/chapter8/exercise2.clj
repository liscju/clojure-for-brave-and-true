(ns clojure-for-brave-and-true.chapter8.exercise2)

(defmacro my-or
  ([] true)
  ([x] x)
  ([x & xs]
    `(let [and# ~x]
       (if and#
         and#
         (my-or ~@xs)))))
