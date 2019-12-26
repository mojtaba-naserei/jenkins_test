job('DSL-Tutorial-1-Test') {
    scm {
        git('git://github.com/contentful/the-example-app.nodejs.git')
    }
    triggers {
        scm('H/15 * * * *')
    }
    wrappers { 
       nodejs('nodejs8')
    }
    steps {
        shell('npm install')   
    }
}
