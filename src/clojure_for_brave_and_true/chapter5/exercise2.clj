(ns clojure-for-brave-and-true.chapter5.exercise2)

(defn comp
  "Returns composed function"
  ([] identity)
  ([f] f)
  ([f g] (fn [x] (f (g x))))
  ([f g & fns]
   (fn [x]
     (reduce (fn [val h] (h val))
             x
             (cons f (cons g fns))))))