import 'package:flutter/material.dart';

abstract class Composable {
  Widget compose(Map<String, dynamic> map, BuildContext context);
}