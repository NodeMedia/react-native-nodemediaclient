//
//  RTCNodeCameraManager.m
//
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017年 NodeMedia. All rights reserved.
//
#import <React/RCTViewManager.h>
#import <React/RCTBridge.h>
#import <React/RCTUIManager.h>
#import "RCTNodeCameraView.h"

@interface RCTNodeCameraManager : RCTViewManager

@end

@implementation RCTNodeCameraManager
RCT_EXPORT_MODULE()

- (UIView *)view {
  return [[RCTNodeCameraView alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(outputUrl, NSString)
RCT_EXPORT_VIEW_PROPERTY(autopreview, BOOL)
RCT_EXPORT_VIEW_PROPERTY(camera, NSDictionary);
RCT_EXPORT_VIEW_PROPERTY(audio, NSDictionary);
RCT_EXPORT_VIEW_PROPERTY(video, NSDictionary);
RCT_EXPORT_VIEW_PROPERTY(denoise, BOOL);
RCT_EXPORT_VIEW_PROPERTY(dynamicRateEnable, BOOL);
RCT_EXPORT_VIEW_PROPERTY(smoothSkinLevel, int);
RCT_EXPORT_VIEW_PROPERTY(cryptoKey, NSString)
RCT_EXPORT_VIEW_PROPERTY(onChange, RCTBubblingEventBlock)


RCT_EXPORT_METHOD(startprev:(nonnull NSNumber *)reactTag)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view startprev];
   }];
}


RCT_EXPORT_METHOD(stopprev:(nonnull NSNumber *)reactTag)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view stopprev];
   }];
}

RCT_EXPORT_METHOD(start:(nonnull NSNumber *)reactTag)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view start];
   }];
}

RCT_EXPORT_METHOD(stop:(nonnull NSNumber *)reactTag)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view stop];
   }];
}

RCT_EXPORT_METHOD(switchCamera:(nonnull NSNumber *)reactTag)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view switchCamera];
   }];
}

RCT_EXPORT_METHOD(flashEnable:(nonnull NSNumber *)reactTag enable:(BOOL)enable)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view setFlashEnable:enable];
   }];
}

RCT_EXPORT_METHOD(setVideoParamPreset:(nonnull NSNumber *)reactTag video:(NSDictionary *)video)
{
  
  [self.bridge.uiManager addUIBlock:
   ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RCTNodeCameraView *> *viewRegistry){
     RCTNodeCameraView *view = viewRegistry[reactTag];
     [view setVideoParamPreset:video];
   }];
}

@end
