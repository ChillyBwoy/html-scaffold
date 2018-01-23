(ns {{ns-name}}.handler
  (:require [compojure.core :refer [defroutes GET routes]]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [hiccup.middleware :refer (wrap-base-url)]
            [{{ns-name}}.app :as app]
            [{{ns-name}}.views.not-found :as not-found]
            [{{ns-name}}.data :as data]))

(def context (data/create-context))

(defroutes app-routes
  (apply routes
    (map
      (fn [[url args view]]
        (GET url args view))
      (app/routes context)))
  (route/resources "/")
  (route/not-found (not-found/view context)))


(def app
  (-> (handler/site app-routes)
      (wrap-base-url)))
