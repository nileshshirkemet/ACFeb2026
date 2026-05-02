import taxation.Supervisor;
import taxation.Worker;

void doAuditing(String name, int count) {
    //try-with-resources can be used with AutoCloseable class
    try(var a = new Auditor()){
        if(count > 10)
            a.audit(name, new Worker(count));
        else
            a.audit(name, new Supervisor(count));
    }//automatically calls a.close()

}

void main(String[] args) {
    try{
        String m = args[0];
        int n = Integer.parseInt(args[1]);
        doAuditing(m, n);
    }catch(Exception e){
        IO.println(e);
    }

}