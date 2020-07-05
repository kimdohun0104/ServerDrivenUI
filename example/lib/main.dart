import 'package:dynamic_ui/page/foo_page.dart';
import 'package:dynamic_ui/page/poo_page.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      initialRoute: '/foo',
      routes: {
        '/foo': (_) => FooPage(),
        '/poo': (_) => PooPage(),
      },
    );
  }
}
