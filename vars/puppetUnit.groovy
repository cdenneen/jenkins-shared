#!/usr/bin/groovy

def call(Closure body) {
  sh 'STRICT_VARIABLES=no bundle exec rake spec'
}
