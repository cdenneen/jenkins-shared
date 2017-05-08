#!/usr/bin/groovy

def call(Closure body) {
  sh 'gem install bundler --no-document'
  sh 'bundle install --without system_tests'
}
