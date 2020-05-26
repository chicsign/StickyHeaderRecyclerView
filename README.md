# StickyHeaderRecyclerView
A recyclerView that can be scrolled together by placing different types of views over a fixed header.

# Introduction
  This is a Sticky Header RecyclerView implemented using ItemDecoration without using a library.
  Actions are classified according to ItemViewType.

  There are 4 types in use, and users can add and edit them.
<pre>
<code>
  companion object {
           const val TYPE_TOP = 0
           const val TYPE_HOLDER = 1
           const val TYPE_EMPTY = 2
           const val TYPE_LIST = 3
       }
</code>
</pre>

TYPE_TOP is the type that will appear before the index of the view to be fixed.

TYPE_HOLDER is the type to be fixed at the top of the recycler view.

TYPE_EMPTY is a view type that is drawn when there is no data in the list.

TYPE_LIST is the view type on which data is drawn.

See my blog for detailed instructions.
> https://dailylonnie0125.tistory.com/

# OverView

![sticky_header_recyclerView_sample](https://user-images.githubusercontent.com/33883893/82872612-3ef9d200-9f6e-11ea-9e76-05b9dd78ef1f.gif)

# Reference

https://github.com/paetztm/recycler_view_headers/blob/master/app/src/main/java/timothypaetz/com/recyclersectionheader/MainActivity.java

# License
  Copyright 2020 chicsign

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
