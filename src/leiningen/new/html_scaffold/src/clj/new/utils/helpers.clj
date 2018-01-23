(ns {{ns-name}}.utils.helpers)


(defn create-helpers
  [{:keys [prefix suffix]}]
  {:get-url (fn [x] (str "../" prefix "/" x suffix))})
