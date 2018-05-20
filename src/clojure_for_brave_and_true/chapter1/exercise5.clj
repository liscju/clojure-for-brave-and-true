(ns clojure-for-brave-and-true.chapter1.exercise5)

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "%num%-eye" :size 1}
                             {:name "%num%-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "%num%-shoulder" :size 3}
                             {:name "%num%-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "%num%-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "%num%-kidney" :size 1}
                             {:name "%num%-hand" :size 2}
                             {:name "%num%-knee" :size 2}
                             {:name "%num%-thigh" :size 4}
                             {:name "%num%-lower-leg" :size 3}
                             {:name "%num%-achilles" :size 1}
                             {:name "%num%-foot" :size 2}])

(defn matching-part
  [part i]
  {:name (clojure.string/replace (:name part) #"^%num%" (str i))
   :size (:size part)})

(defn generate-parts
  [part]
  (map #(matching-part part %) [1 2 3 4 5]))

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set (generate-parts part))))))))

(println (symmetrize-body-parts asym-hobbit-body-parts))