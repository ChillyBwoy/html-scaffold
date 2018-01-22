(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]
                 [hiccup "1.0.5"]
                 [compojure "1.6.0"]
                 [proto-repl "0.3.1"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.7"]
            [lein-create-template "0.2.0"]
            [lein-cljfmt "0.5.7"]]
  :ring {:handler {{ns-name}}.handler/app
         :auto-reload? true
         :auto-refresh? true
         :port 4000}
  :source-paths ["src/clj"]
  :jvm-opts ["--add-modules" "java.xml.bind"]
  :cljfmt {:indentation? false}
  :aliases {"render" ["run" "-m" "{{ns-name}}.render"]}
  :cljsbuild {:repl-listen-port 4001
              :builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/bundles/app.dev.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}
                       {:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/bundles/app.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]})
