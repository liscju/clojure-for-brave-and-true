(ns clojure-for-brave-and-true.chapter8.exercise3)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})
;(def c-int (comp :intelligence :attributes))
;(def c-str (comp :strength :attributes))
;(def c-dex (comp :dexterity :attributes))

(defmacro defattrs
  [& fattrs]
  (let [fun# (first fattrs)
        attr# (second fattrs)
        rest# (drop 2 fattrs)]
    `(do (def ~fun# (comp ~attr# :attributes))
         (defattrs ~@rest#))
   ))

(defmacro defattrs
  [& fattrs]
  `(do ~@(map #(`(~%1 ~%2)) [])))




