(ns {{ns-name}}.handler
  (:require [compojure.core :refer [defroutes GET routes]]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [hiccup.middleware :refer (wrap-base-url)]
            [{{ns-name}}.core :as core]
            [{{ns-name}}.layout :as layout]
            [{{ns-name}}.views.not-found :as not-found]))


(def context {:title "{{ns-name}}"})


(defroutes app-routes
  (apply routes
    (map
      (fn [[url args view]]
        (GET url args view))
      (core/routes context)))
  (route/resources "/")
  (route/not-found (layout/base
                     (conj context {:title "404"})
                     (not-found/view context))))

(def app
  (-> (handler/site app-routes)
      (wrap-base-url)))
