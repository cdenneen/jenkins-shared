#!/usr/bin/groovy

def call(Closure body) {
  sh 'bundle exec rake lint'
}
