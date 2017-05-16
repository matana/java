# java
<table>
   <tr>
        <th>#</th>
        <th>Themen</th>
        <th>Literatur</th>
        <th>Projekt</th>
        <th>TODOs</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Einfach verkettete Liste, JUnit-Tests</td>
        <td>
          <ul>
            <li><a href="http://www.spinfo.phil-fak.uni-koeln.de/29962.html" target="_blank">Vor- und Nachteile von Arrays und Vektoren</a></li>
            <li><a href="http://junit.org/junit4/" target="_blank">About JUnit</a></li>
          <ul>
        </td>
        <td><a href="https://github.com/matana/java/tree/master/linkedList">linkedList</a></td>
        <td>
          <p>Die Klasse <a href="https://github.com/matana/java/blob/master/linkedList/src/linkedList/simple/List.java">List</a> beinhaltet drei Methoden, welche implementiert werden sollen:</p>
          <ul>
            <li><p><code>public int[] toArray()</code></p>
               <p> // Gibt die Liste als Array vom Typ int zurück.</p>
            </li>
            <li><p><code>public int indexOf(int value)</code></p>
                <p> // Gibt die Indexposition von 'value' innerhalb der Liste zurück.</p>
            </li>
            <li><p><code>public List subList(int from, int to)</code></p>
                <p> // Erstellt eine Teilliste mithilfe der Indices 'from' und 'to'.</p>
            </li>
            <li><p><code>public void insertFirst(int value)</code></p>
                <p> // Fügt den übergebenen Wert an die erste Position der Liste.</p>
            </li>
          </ul>
          <p>Erstellen Sie in der Klasse <a href="https://github.com/matana/java/blob/master/linkedList/src/linkedList/LinkedListTests.java">LinkedListTests</a> entsprechende Unit-Tests, die die Funktionalität Ihrer Implementationen überprüfen.</p>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>Stack, Generics, Iterable</td>
        <td>
            <ul>
               <li>
                  <a href="http://www.torsten-horn.de/techdocs/java-generics.htm">Generics</a>
               </li>
               <li>
                  <a href="http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_09_005.htm#mjaedac022d8feb8adeb6b664e81d2e969">Iterable</a>
                  </li>
            </ul>
        </td>
        <td><a href="https://github.com/matana/java/tree/master/stack">stack</a></td>
        <td>
          Erstellen Sie das Interface <code>Collection</code>, welches gemeinsame Methoden (u.a. size, toArray,  deleteAll, contains, remove(int x) und count (int x) - diese Methode gibt die Anzahl der Vorkommnisse von 'x' zurück) der <a href="https://github.com/matana/java/tree/master/linkedList">linkedList</a> und <a href="https://github.com/matana/java/tree/master/stack">stack</a> definiert. <code>Collection</code> soll zudem das Interface <code>Interable</code> erweitern. Implementieren Sie anschließend das Interface in den Klassen <a href="https://github.com/matana/java/blob/master/linkedList/src/linkedList/simple/List.java">List</a> und <a href="https://github.com/matana/java/blob/master/stack/src/stack/Stack.java">Stack</a>.<br><br> Fakultativ: Bisher ist es nur möglich Integer im Stack zu speichern. Passen Sie das Projekt <a href="https://github.com/matana/java/tree/master/stack">stack</a> so an, dass generische Datentypen (bspw. <code>Stack&lt;String&gt; stack = new Stack&lt;String&gt;()</code>) abgelegt werden können. 
        </td>
    </tr>
</table>
