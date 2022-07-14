node("master") {
        // This is a demo
    def buildNumberId = getBuildNumber()
    try {
            
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
