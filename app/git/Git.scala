package git

case object Git {

  def init() = Init() exec

  def log() = Log() exec

  def status(options:(Option[Boolean],Option[Boolean],Option[Boolean],Option[Boolean])) = {

    val (short,branch,porcelain,long) = options
    
    Status(short,branch,porcelain,long) exec
  }

  def diff(files:List[String]) = Diff(files) exec

  def add(files:List[String]) = Add(files) exec

  def commit(message:String) = Commit(message) exec

  def clone(repository:String) = Clone(repository) exec

  def stash(stash:List[String]) = Stash(stash) exec

  def reset(reset:String) = Reset(reset) exec

  def checkout(branch:String) = Checkout(branch) exec

  def merge(branch:String) = Merge(branch) exec

  def branch(name:String) = Branch(name) exec

  def fetch(remote:String)(branch:String) = Fetch(remote,branch) exec

  def pull(remote:String)(branch:String) = Pull(remote,branch) exec

  def push(remote:String)(branch:String) = Push(remote,branch) exec

  def bisect(choice:BisectChoice) = Bisect(choice) exec

  def rebase(options:String) = Rebase(options) exec

  def tag(branch:String) = Tag(branch) exec
  
}
