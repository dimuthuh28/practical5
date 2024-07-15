object three extends App{
  def fibonacci(n:Int):Int= n match{
    case x if x==0 => 0
    case x if x==1 => 1
    case x => fibonacci(n-1)+fibonacci(n-2)
    }

    println(fibonacci(5));
}