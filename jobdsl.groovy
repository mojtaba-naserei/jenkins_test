job('DSL-with-docker') {
    scm {
        git('git://github.com/contentful/the-example-app.nodejs.git', 'master') { node ->
            node / gitConfigName('mojtaba job dsl')
            node / gitConfigEmail('mojtaba.naserei@gmail.com')
        }
    }
    triggers {
        scm('H/15 * * * *')
    }
    wrappers { 
       nodejs('nodejs8')
    }
    steps {
      dockerBuildAndPublish {
            repositoryName('mojtabanaserei/jenkins')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
}
