node("master") {
        // This is a demo
    try {
            def buildNumberId = getBuildNumber()
            stage("Checking out SCM") {
        // try{
            checkout scm
             echo '*** $buildNumberId ***'
        // }
        
    }
    }
   catch (Exception e) {
             echo 'Exception occurred dureing Checkout: ' + e.toString()
             sh 'Handle the exception!'
        }  

}
