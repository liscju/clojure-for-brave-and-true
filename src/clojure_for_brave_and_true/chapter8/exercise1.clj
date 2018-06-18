(ns clojure-for-brave-and-true.chapter8.exercise1)

(def order-details
  {:name "Mitchard Blimmons"
   :email "mitchard.blimmons@gmail.com"})

(def order-details-validations
  {:name
   ["Please enter a name" not-empty]
   :email
   ["Please enter an email address" not-empty

    "Your email address does not look like an email address"
    #(or (empty? %) (re-seq #"@" %))]})

(defn error-messages-for
  "Return a seq of error messages"
  [to-validate message-validator-pairs]
  (map first (filter #(not ((second %) to-validate))
                     (partition 2 message-validator-pairs))))

(defn validate
  "Returns a map with a vector of errors for each key"
  [to-validate validations]
  (reduce (fn [errors validation]
            (let [[fieldname validation-check-groups] validation
                  value (get to-validate fieldname)
                  error-messages (error-messages-for value validation-check-groups)]
              (if (empty? error-messages)
                errors
                (assoc errors fieldname error-messages))))
          {}
          validations))

(defmacro if-valid
  "Handle validation more consisely"
  [to-validate validations errors-name & then-else]
  `(let [~errors-name (validate ~to-validate ~validations)]
     (if (empty? ~errors-name)
       ~@then-else)))

(defmacro when-valid
  [order-details order-details-validations & then]
  `(when (empty? (validate order-details order-details-validations))
     ~@then))