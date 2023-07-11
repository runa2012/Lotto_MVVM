<h2>Android Kotlin MVVM Example</h2>
<p>Lotto 번호를 생성하여 보여주는 간단한 MVVM 패턴을 이용한 기본적인 예제 입니다.</p>
<p>MVVM을 이해하면서 DataBinding ViewBinding을 같이 이해할 수 있도록 하였습니다.</p>
</br>
<p>
  <strong>View</strong> - ViewMdel에게 이벤트나 데이터 요청을 합니다.</br>
  
  <strong>ViewModel</strong> - View와 Model 사이의 매개체 역할을 합니다. Model에서 제공받는 데이터를 View로 보내줍니다.</br>
  
  <strong>Model</strong> - 데이터를 처리합니다.
</p>
</br>
<h2>라이브러리</h2>
<ul>
<li><p>Navigation - Jetpack</p></li>
<li><p>Data Binding</p></li>
<li><p>ViewBinding</p></li>
<li><p>LiveData</p></li>
<li><p>StateFlow</p></li>
<li><p>MVVM - AAC</p></li>
</ul>
</br>
<h2>패키지 구조</h2>
<ul>
  <li>    
    <p>base</p>
    <ul>
      <li>BaseFragment</li>
      <li>BaseViewModel</li>
    </ul>
  </li>  
</ul>
<ul>
  <li>    
    <p>model</p>
    <ul>
      <li>Lotto_model</li>    
    </ul>
  </li>  
</ul>
<ul>
  <li>    
    <p>type</p>
    <ul>
      <li>EnumViewType</li>    
    </ul>
  </li>  
</ul>
<ul>
  <li>    
    <p>ui/exdata</p>
    <ul>
      <li>lotto_adapter</li>    
      <li>Lotto_viweHolder</li>    
      <li>DataBindingViewModel</li>    
      <li>DatabindingFragment</li>
    </ul>
  </li>  
</ul>
<ul>
  <li>    
    <p>ui/exview</p>
    <ul>
      <li>lotto_VM_adapter</li>    
      <li>Lotto_VM_viweHolder</li>    
      <li>viewBindingViewModel</li>    
      <li>viewbindingFragment</li>
    </ul>
  </li>  
</ul>
<ul>
  <li>    
    <p>ui/MainActivity</p> 
  </li>  
</ul>
