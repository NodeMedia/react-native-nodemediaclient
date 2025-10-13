//
//  RCTNodePlayerManager.m
//
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

#import <React/RCTViewManager.h>
#import <React/RCTUIManager.h>
#import "RCTNodeMediaClient.h"
#import "RCTNodePlayerView.h"

@interface RCTNodePlayerManager : RCTViewManager

@end

@implementation RCTNodePlayerManager

RCT_EXPORT_MODULE()
RCT_EXPORT_VIEW_PROPERTY(url, NSString)
RCT_EXPORT_VIEW_PROPERTY(volume, float)
RCT_EXPORT_VIEW_PROPERTY(bufferTime, int)
RCT_EXPORT_VIEW_PROPERTY(scaleMode, int)
RCT_EXPORT_VIEW_PROPERTY(cryptoKey, NSString)
RCT_EXPORT_VIEW_PROPERTY(HWAccelEnable, BOOL)
RCT_EXPORT_VIEW_PROPERTY(HTTPReferer, NSString)
RCT_EXPORT_VIEW_PROPERTY(HTTPUserAgent, NSString)
RCT_EXPORT_VIEW_PROPERTY(onChange, RCTBubblingEventBlock)

RCT_EXPORT_METHOD(start:(nonnull NSNumber *)reactTag)
{
  [self.bridge.uiManager addUIBlock: ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodePlayerView *> *viewRegistry){
      RCTNodePlayerView *view = viewRegistry[reactTag];
      [view start];
   }];
}

RCT_EXPORT_METHOD(stop:(nonnull NSNumber *)reactTag)
{
  
  [self.bridge.uiManager addUIBlock: ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodePlayerView *> *viewRegistry){
      RCTNodePlayerView *view = viewRegistry[reactTag];
      [view stop];
   }];
}


- (UIView *)view
{
  return [[RCTNodePlayerView alloc] init];
}

@end
