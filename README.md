# ServerDrivenUI
Flutter를 사용하여 Server Driven UI(이하 SDUI)를 간단하게 구현해보았습니다.  
만약 SDUI의 개념이 궁금하시다면 [제가 작성한 블로그](https://medium.com/@dikolight203/server-driven-ui-feat-flutter-87fcbb04e610)를 참고해주세요.  


이 저장소는 2개의 프로젝트가 존재합니다.
1. Flutter example - 플러터를 사용하여 SDUI를 간단하게 구현합니다.
2. Document Kotlin DSL - SDUI의 문서를 작성을 위한 Kotlin DSL  
---
### 1. Flutter example
#### Composable
```dart
abstract class Composable {
  Widget compose(Map<String, dynamic> map, BuildContext context);
}

class FooAppBarComposer implements Composable {
  @override
  Widget compose(Map<String, dynamic> map, BuildContext context) {
    final String title = map['content']['title'];
    return AppBar(
      title: Text(title),
    );
  }
}
```
Composable 추상 클래스는 compose함수를 포함하고 있습니다. 이 compose 함수는 하나의 ViewComponent를 리턴합니다.  
예시로 Composable을 구현하는 FooAppBarComposer 를 확인해봅시다. map을 통해 서버에서 전달받은 content에 접근하여 AppBar를 구성하여 리턴하는 모습입니다.  

#### ComposableScaffold
```dart
class ComposableScaffold extends StatelessWidget {
  final List<Map<String, dynamic>> composerInfoMaps;
  final Map<String, Composable> composerByName;

  ComposableScaffold({this.composerInfoMaps, this.composerByName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: composerInfoMaps
          .map((widget) => composerByName[widget['type']].compose(widget, context))
          .toList()),
    );
  }
}

composerByName: {
    'FooAppBar': FooAppBarComposer(),
    'FooButton': FooButtonComposer()
}
```
composerByName을 통해 서버에서 불러온 type과 구현된 Composer를 매핑합니다.  
composerByName에서 해당 type을 통해 composer를 찾아 compose로 위젯을 구성합니다.

---

### 2. Document Kotlin DSL
Document DSL은 열심히 작업중입니다! 추후에 README 업데이트하도록 하겠습니다.  
지금까지 완성된 예제 코드는 다음과 같습니다. 
```kotlin
document {

        component("FooButton") {
            description("This is a FooButton")

            content("text", DataType.STRING) {
                description("This is text")

                example("HelloWorld")
            }

            content("subText", DataType.STRING, nullable = true) {
                description("This is subText")

                example("SubText")
            }

            action(Intent.NAVIGATION) {
                description("This is navigation event to poo")

                data {
                    route("/poo") {
                        argument("id", DataType.STRING)
                        argument("password", DataType.STRING)
                    }
                }
            }
        }
    }
```
